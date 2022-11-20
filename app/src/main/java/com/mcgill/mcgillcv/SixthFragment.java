package com.mcgill.mcgillcv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.mcgill.mcgillcv.databinding.FragmentSecondBinding;
import com.mcgill.mcgillcv.databinding.FragmentSixthBinding;
import com.mcgill.mcgillcv.databinding.FragmentThirdBinding;

public class SixthFragment  extends Fragment {

    private FragmentSixthBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSixthBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSixthPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SixthFragment.this)
                        .navigate(R.id.action_SixthFragment_to_FifthFragment);
            }
        });
        binding.buttonSixthNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SixthFragment.this)
                        .navigate(R.id.action_SixthFragment_to_SeventhFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
