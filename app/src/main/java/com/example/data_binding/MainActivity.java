package com.example.data_binding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.data_binding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sText = binding.etInput.getText().toString().trim();
                if (!sText.equals("")) {
                    binding.tvOutput.setText(sText);
                } else {
                    Toast.makeText(getApplicationContext(), "Please Enter Text", Toast.LENGTH_SHORT).show();
                }
            }
        });
            Fragment fragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment,fragment).commit();
    }
}