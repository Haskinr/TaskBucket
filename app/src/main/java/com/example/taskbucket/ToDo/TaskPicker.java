package com.example.taskbucket.ToDo;

import static com.example.taskbucket.MainActivity.masterlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taskbucket.R;
import com.example.taskbucket.databinding.FragmentTaskPickerBinding;
import com.example.taskbucket.tasks.Task;
import com.example.taskbucket.tasks.TaskList;

public class TaskPicker extends Fragment {

    private FragmentTaskPickerBinding binding;
    private TaskList pickerlist;
    private Task pickedtask;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentTaskPickerBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pickerlist = masterlist;

        binding.pickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picknewtask();
            }
        });

        binding.doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pickedtask == null){
                    //todo figure this out later

                } else{
                    pickedtask.done();
                    //todo logic for removing from picker list and updating master list
                    Toast test = new Toast(v.getContext());
                    test.setText(String.valueOf(pickedtask.getId()));
                    //test.show();

                    pickerlist.removeTask(pickedtask.getId(), v.getContext());

                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void picknewtask(){
        pickedtask = pickerlist.randomtask();
        if (pickedtask == null){
            binding.taskTitle.setText("All Done!");
            return;
        }

        // TODO: 3/28/2024 replace with logic for full task card instead of just title
        binding.taskTitle.setText(pickedtask.getName());
    }
}