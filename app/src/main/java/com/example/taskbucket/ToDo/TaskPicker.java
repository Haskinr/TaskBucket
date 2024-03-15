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
import com.example.taskbucket.tasks.TaskList;

public class TaskPicker extends Fragment {

    private FragmentTaskPickerBinding binding;
    private TaskList pickerlist;

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
                // TODO: 3/11/2024 Picker logic
                Toast testtoast = new Toast(view.getContext());
                testtoast.setText(pickerlist.getTaskName(1));
                testtoast.show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}