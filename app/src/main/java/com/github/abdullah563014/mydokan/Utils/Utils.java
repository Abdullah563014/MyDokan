package com.github.abdullah563014.mydokan.Utils;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.github.abdullah563014.mydokan.MainActivity;
import com.github.abdullah563014.mydokan.database.DatabaseClient;
import com.github.abdullah563014.mydokan.database.Task;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    Context context;

    public static class InsertAsyncTask extends AsyncTask<Void, Void, Void> {
        Context context;
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
        public InsertAsyncTask(Context context,String date ,String electric, String store, String car,String guest,String donation, String commute, String commission, String mixed,String shareHolder,String habibureVai,String faizullahVai, String motorcycle){
            this.context=context;
            this.date=date;
            this.electric=electric;
            this.store=store;
            this.car=car;
            this.guest=guest;
            this.donation=donation;
            this.commute=commute;
            this.commission=commission;
            this.mixed=mixed;
            this.shareHolder=shareHolder;
            this.habibureVai=habibureVai;
            this.faizullahVai=faizullahVai;
            this.motorcycle=motorcycle;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Task task = new Task(date, electric, store, car, guest, donation, commute, commission, mixed, shareHolder, habibureVai, faizullahVai, motorcycle);
            DatabaseClient.getInstance(context.getApplicationContext()).getTaskDatabase().taskDao().insert(task);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(context, "Insertion Successful", Toast.LENGTH_SHORT).show();
        }
    }

    public static class LoadDataAsyncTask extends AsyncTask<Void,Void,Void> {
        Context context;
        public LoadDataAsyncTask(Context context){
            this.context=context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            MainActivity.list.clear();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            List<Task> demoList =DatabaseClient.getInstance(context.getApplicationContext()).getTaskDatabase().taskDao().getAll();
            MainActivity.list.addAll(demoList);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(context, "Data Loaded Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
