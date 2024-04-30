package com.example.taskbucket.ToPlan;

import static com.example.taskbucket.MainActivity.masterlist;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taskbucket.R;
import com.example.taskbucket.database.TaskBucketViewModel;
import com.example.taskbucket.databinding.FragmentNewTaskBinding;
import com.example.taskbucket.tasks.Task;

public class NewTaskFragment extends Fragment {
    private FragmentNewTaskBinding binding;
    private TaskBucketViewModel tbvm;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_new_task, container, false);

        tbvm = new ViewModelProvider(this).get(TaskBucketViewModel.class);

        binding = FragmentNewTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable etext = binding.inputNewTaskName.getText();
                //masterlist.addTask(new Task(etext.toString()));

                long testlong = tbvm.insert(new Task(etext.toString()));

                Toast test = new Toast(view.getContext());
                test.setText(String.valueOf(testlong));
               // test.show();

                NavHostFragment.findNavController(NewTaskFragment.this)
                        .navigate(R.id.action_newTaskFragment_to_TaskListFragment);
            }
        });
    }
}