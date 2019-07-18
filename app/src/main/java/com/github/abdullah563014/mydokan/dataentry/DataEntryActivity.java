package com.github.abdullah563014.mydokan.dataentry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.abdullah563014.mydokan.R;

public class DataEntryActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    EditText
            dateEditText,
            salaryEditText,
            electricEditText,
            storeEditText,
            carEditText,
            guestEditText,
            donationEditText,
            commuteEditText,
            commissionEditText,
            mixedEditText,
            shareHolderEditText,
            habibureVaiEditText,
            faizullahVaiEditText,
            motorcycleEditText;
    Button submitButton;
    String date,
            salary,
            electric,
            store,
            car,
            guest,
            donation,
            commute,
            commission,
            mixed,
            shareHolder,
            habibureVai,
            faizullahVai,
            motorcycle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initializeAll();
    }

    private void initializeAll(){
        dateEditText=findViewById(R.id.dateTimePickerEditTextId);
        salaryEditText=findViewById(R.id.salaryEditTextId);
        electricEditText=findViewById(R.id.electricBillEditTextId);
        storeEditText=findViewById(R.id.storeBillEditTextId);
        carEditText=findViewById(R.id.carBillEditTextId);
        guestEditText=findViewById(R.id.guestBillEditTextId);
        donationEditText=findViewById(R.id.donationEditTextId);
        commuteEditText=findViewById(R.id.commuteBillEditTextId);
        commissionEditText=findViewById(R.id.commissionEditTextId);
        mixedEditText=findViewById(R.id.bibidhKhorocEditTextId);
        shareHolderEditText=findViewById(R.id.shareHolderEditTextId);
        habibureVaiEditText=findViewById(R.id.habibureVaiEditTextId);
        faizullahVaiEditText=findViewById(R.id.faizullahVaiEditTextId);
        motorcycleEditText=findViewById(R.id.motorcycleBillEditTextId);
        submitButton=findViewById(R.id.billSubmitButtonId);

        dateEditText.setOnClickListener(this);
        salaryEditText.setOnClickListener(this);
        electricEditText.setOnClickListener(this);
        storeEditText.setOnClickListener(this);
        carEditText.setOnClickListener(this);
        guestEditText.setOnClickListener(this);
        donationEditText.setOnClickListener(this);
        commuteEditText.setOnClickListener(this);
        commissionEditText.setOnClickListener(this);
        mixedEditText.setOnClickListener(this);
        shareHolderEditText.setOnClickListener(this);
        habibureVaiEditText.setOnClickListener(this);
        faizullahVaiEditText.setOnClickListener(this);
        motorcycleEditText.setOnClickListener(this);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.billSubmitButtonId:
                gaterAllValueFromEditText();
                break;
        }
    }

    private void gaterAllValueFromEditText(){
        date=dateEditText.getText().toString();
        salary=salaryEditText.getText().toString();
        electric=electricEditText.getText().toString();
        store=storeEditText.getText().toString();
        car=carEditText.getText().toString();
        guest=guestEditText.getText().toString();
        donation=donationEditText.getText().toString();
        commute=commuteEditText.getText().toString();
        commission=commissionEditText.getText().toString();
        mixed=mixedEditText.getText().toString();
        shareHolder=shareHolderEditText.getText().toString();
        habibureVai=habibureVaiEditText.getText().toString();
        faizullahVai=faizullahVaiEditText.getText().toString();
        motorcycle=motorcycleEditText.getText().toString();
    }
}
