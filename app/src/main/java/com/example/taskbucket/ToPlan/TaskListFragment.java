package com.example.taskbucket.ToPlan;

import static com.example.taskbucket.MainActivity.masterlist;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taskbucket.R;
import com.example.taskbucket.databinding.FragmentTasklistBinding;
import com.example.taskbucket.tasks.Task;


public class TaskListFragment extends Fragment {
    private FragmentTasklistBinding binding;

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentTasklistBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TaskListFragment.this)
                        .navigate(R.id.action_TaskListFragment_to_newTaskFragment);
            }
        });
        //todo - rework for scrolling table view
       TableLayout taskTable = binding.taskTable;
            TableRow newrow = new TableRow(view.getContext());
            TextView success = new TextView(view.getContext());
            success.setText(masterlist.getTaskName(1));
            newrow.addView(success);
            taskTable.addView(newrow);

    }

}