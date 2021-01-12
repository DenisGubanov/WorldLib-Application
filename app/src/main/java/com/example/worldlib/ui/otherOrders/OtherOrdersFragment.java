package com.example.worldlib.ui.otherOrders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.worldlib.R;

public class OtherOrdersFragment extends Fragment {

    private OtherOrdersViewModel otherOrdersViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        otherOrdersViewModel =
                new ViewModelProvider(this).get(OtherOrdersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_otherorders, container, false);
        final TextView textView = root.findViewById(R.id.text_otherOrders);
        otherOrdersViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}