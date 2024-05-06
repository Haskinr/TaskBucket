package com.example.taskbucket.ToPlan;

import static com.example.taskbucket.MainActivity.masterlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskbucket.R;
import com.example.taskbucket.database.TaskBucketViewModel;
import com.example.taskbucket.databinding.FragmentTasklistBinding;
import com.example.taskbucket.tasks.Task;
import com.example.taskbucket.tasks.TaskList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class TaskListFragment extends Fragment {
    private FragmentTasklistBinding binding;
    private TaskList planlist;
    private TaskBucketViewModel tbvm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTasklistBinding.inflate(inflater, container, false);

        tbvm = new ViewModelProvider(this).get(TaskBucketViewModel.class);

        planlist = new TaskList(new TaskList.TaskDiff());
        planlist.setViewModel(tbvm);
        RecyclerView recyclerView = binding.recyclerview;
        recyclerView.setAdapter(planlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TaskListFragment.this).navigate(R.id.action_TaskListFragment_to_newTaskFragment);
            }
        });

tbvm.getAllTasks().observe(this.getViewLifecycleOwner(), tasks -> {
        planlist.submitList(tasks);
        int count = planlist.getItemCount();
        Toast toast = new Toast(this.getContext());
        toast.setText(String.valueOf(count));
        toast.show();
        });
        //todo - rework for scrolling table view

     /*   for (Task t: planlist.getTasks()
        ) {
            TableLayout taskTable = binding.taskTable;
            TableRow newrow = new TableRow(view.getContext());
            TextView success = new TextView(view.getContext());
            success.setText(t.getName());
            newrow.addView(success);
            // make the delete button
            FloatingActionButton delete_btn = new FloatingActionButton(view.getContext());
            delete_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: 3/21/2024 fill in with actual delete logic
                    Toast deletetoast = new Toast(v.getContext());
                    deletetoast.setText("deleting "+ t.getName());
                    deletetoast.show();
                }
            }

        );
            newrow.addView(delete_btn);
            taskTable.addView(newrow);
        }*/

    }

}