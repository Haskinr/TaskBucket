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
        tbvm = new ViewModelProvider(this).get(TaskBucketViewModel.class);
        planlist = new TaskList();
        binding = FragmentTasklistBinding.inflate(inflater, container, false);
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
        //todo - rework for scrolling table view
        planlist.getAllDbTasks(tbvm);
        for (Task t: planlist.getTasks()
        ) {// get the title
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
                    Toast testtoast = new Toast(v.getContext());
                    testtoast.setText("deleting "+ t.getName());
                    testtoast.show();
                }
            }

        );
            newrow.addView(delete_btn);
            taskTable.addView(newrow);
        }

    }

}