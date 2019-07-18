package com.github.abdullah563014.mydokan.dataentry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.github.abdullah563014.mydokan.R;
import com.github.abdullah563014.mydokan.Utils.Utils;
import com.github.abdullah563014.mydokan.database.DatabaseClient;
import com.github.abdullah563014.mydokan.database.Task;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataEntryActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener calenderDate;
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
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initializeAll();

        getCalenderDate();
    }

    private void initializeAll() {
        dateEditText = findViewById(R.id.dateTimePickerEditTextId);
        salaryEditText = findViewById(R.id.salaryEditTextId);
        electricEditText = findViewById(R.id.electricBillEditTextId);
        storeEditText = findViewById(R.id.storeBillEditTextId);
        carEditText = findViewById(R.id.carBillEditTextId);
        guestEditText = findViewById(R.id.guestBillEditTextId);
        donationEditText = findViewById(R.id.donationEditTextId);
        commuteEditText = findViewById(R.id.commuteBillEditTextId);
        commissionEditText = findViewById(R.id.commissionEditTextId);
        mixedEditText = findViewById(R.id.bibidhKhorocEditTextId);
        shareHolderEditText = findViewById(R.id.shareHolderEditTextId);
        habibureVaiEditText = findViewById(R.id.habibureVaiEditTextId);
        faizullahVaiEditText = findViewById(R.id.faizullahVaiEditTextId);
        motorcycleEditText = findViewById(R.id.motorcycleBillEditTextId);
        submitButton = findViewById(R.id.billSubmitButtonId);

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
        switch (v.getId()) {
            case R.id.billSubmitButtonId:
                if (gatherAllValueFromEditText()) {
                    Utils.InsertAsyncTask insertAsyncTask=new Utils.InsertAsyncTask(DataEntryActivity.this,date,electric,store,car,guest,donation,commute,commission,mixed,shareHolder,habibureVai,faizullahVai,motorcycle);
                    insertAsyncTask.execute();
                }
                break;
        }
    }

    private boolean gatherAllValueFromEditText() {
        date = dateEditText.getText().toString();
        salary = salaryEditText.getText().toString();
        electric = electricEditText.getText().toString();
        store = storeEditText.getText().toString();
        car = carEditText.getText().toString();
        guest = guestEditText.getText().toString();
        donation = donationEditText.getText().toString();
        commute = commuteEditText.getText().toString();
        commission = commissionEditText.getText().toString();
        mixed = mixedEditText.getText().toString();
        shareHolder = shareHolderEditText.getText().toString();
        habibureVai = habibureVaiEditText.getText().toString();
        faizullahVai = faizullahVaiEditText.getText().toString();
        motorcycle = motorcycleEditText.getText().toString();

        if (date.isEmpty() || salary.isEmpty() || electric.isEmpty() || store.isEmpty() || car.isEmpty() || guest.isEmpty() || donation.isEmpty() || commute.isEmpty() || commission.isEmpty() || mixed.isEmpty() || shareHolder.isEmpty() || habibureVai.isEmpty() || faizullahVai.isEmpty() || motorcycle.isEmpty()) {
            Toast.makeText(this, "Please input all field properly", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }



    private void getCalenderDate(){
        EditText edittext= (EditText) findViewById(R.id.dateTimePickerEditTextId);
        calenderDate = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(DataEntryActivity.this, calenderDate, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }
    private void updateLabel() {
        String myFormat = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

        dateEditText.setText(sdf.format(myCalendar.getTime()));
    }

}
