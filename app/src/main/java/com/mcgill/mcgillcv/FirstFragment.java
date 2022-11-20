package com.mcgill.mcgillcv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.mcgill.mcgillcv.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentFirstBinding binding;

    private Spinner majorSpinner;
    private Spinner minorSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        majorSpinner = (Spinner) view.findViewById(R.id.major_spinner);
        ArrayAdapter<CharSequence> majorAdaptor = ArrayAdapter.createFromResource(getContext(),
                R.array.major, android.R.layout.simple_spinner_item);

        majorAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        majorSpinner.setAdapter(majorAdaptor);
        majorSpinner.setOnItemSelectedListener(this);

        minorSpinner = (Spinner) view.findViewById(R.id.minor_spinner);
        ArrayAdapter<CharSequence> minorAdaptor = ArrayAdapter.createFromResource(getContext(),
                R.array.minor, android.R.layout.simple_spinner_item);

        minorAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minorSpinner.setAdapter(minorAdaptor);
        minorSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected = (String) parent.getItemAtPosition(position);
      //  Toast.makeText(getContext(), selected, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(getContext(), "dsds", Toast.LENGTH_LONG).show();

    }
}