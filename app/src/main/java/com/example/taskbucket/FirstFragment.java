package com.example.taskbucket;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.taskbucket.ToDo.ToDoActivity;
import com.example.taskbucket.ToPlan.PlanActivity;
import com.example.taskbucket.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            Intent planintent = new Intent(view.getContext(), PlanActivity.class);
            Intent dointent = new Intent(view.getContext(), ToDoActivity.class);
        binding.toplanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(planintent);
                //NavHostFragment.findNavController(FirstFragment.this)
                     //   .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.todoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(dointent);
                //NavHostFragment.findNavController(FirstFragment.this)
                //   .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}