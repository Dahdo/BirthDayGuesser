package com.dahdotech.birthdayguesser;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.dahdotech.birthdayguesser.data.BirthdayGuesser;
import com.dahdotech.birthdayguesser.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final BirthdayGuesser birthdayGuesser = new BirthdayGuesser();
    private int birthDate;
    private String set1, set2, set3, set4, set5;
    private int track;


    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setBirthdayGuesser(birthdayGuesser);
        birthdayGuesser.setAskingText(getString(R.string.asking_text));

        birthDate = 0;
        set1 = "01   03   05   07\n09   11   13   15\n17   19   21   23\n25   27   29   31";
        set2 = "02   03   06   07\n10   11   14   15\n18   19   22   23\n26   27   30   31";
        set3 = "04   05   06   07\n12   13   14   15\n20   21   22   23\n28   29   30   31";
        set4 = "08   09   10   11\n12   13   14   15\n24   25   26   27\n28   29   30   31";
        set5 = "16   17   18   19\n20   21   22   23\n24   25   26   27\n28   29   30   31";
        //datesView = findViewById(R.id.dates_view);
        binding.datesView.setTextSize(25);
        binding.datesView.setLineSpacing(0, 1.7f);
        birthdayGuesser.setDateView(set1);
        //binding.datesView.setText(set1);
        track = 0;


    }
    public String returnSet(int count){
        switch (count){
            case 1:
                return set1;
            case 2:
                return set2;
            case 3:
                return set3;
            case 4:
                return set4;
            case 5:
                return set5;
            default:
                return "Something not right, that's all I know!";
        }
    }

    @SuppressLint("SetTextI18n")
    public void noClicked(View view) {
        track++;
        if(track < 5)
            birthdayGuesser.setDateView(returnSet(track + 1));
        //binding.datesView.setText(returnSet(track + 1));
        else{
            binding.invalidateAll();
            birthdayGuesser.setDateView("Your birth date is: " + birthDate);
            //binding.datesView.setText("Your birth date is: " + birthDate);
            binding.buttonsLayout.setVisibility(View.INVISIBLE);
            binding.askingText.setVisibility(View.INVISIBLE);
        }
    }

    @SuppressLint("SetTextI18n")
    public void yesClicked(View view) {
        track++;
        if(track < 5)
            birthdayGuesser.setDateView(returnSet(track + 1));
        //binding.datesView.setText(returnSet(track + 1));
        if(track <= 5){
            birthDate += Integer.parseInt(returnSet(track).substring(0,2));
            System.out.println("track: " + track + " birthDate: " + birthDate);
        }
        if(track == 5){
            binding.invalidateAll();
            birthdayGuesser.setDateView("Your birth date is: " + birthDate);
            //binding.datesView.setText("Your birth date is: " + birthDate);
            binding.buttonsLayout.setVisibility(View.INVISIBLE);
            binding.askingText.setVisibility(View.INVISIBLE);
        }

    }
}