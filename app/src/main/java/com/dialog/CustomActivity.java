package com.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CustomActivity extends DialogFragment {
    String a = "abc";
    String b = "123";
    LayoutInflater inflater;
    View view;
    EditText etUser, etPwd;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.activity_custom, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                etUser = (view.findViewById(R.id.et_username));
                etPwd = (view.findViewById(R.id.et_password));

                String user = etUser.getText().toString();
                String password = etPwd.getText().toString();
                String msg1 = "Success";
                String msg2 = "failure";
                   if (user.equals("abc")){
                        if (password.equals("123"))
                       Toast.makeText(getActivity(), msg1, Toast.LENGTH_LONG).show();
                   }
                   else{
                       Toast.makeText(getActivity(), msg2, Toast.LENGTH_LONG).show();
                   }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                dialogInterface.cancel();
            }
        });

        builder.setTitle("Login");

        Dialog dialog = builder.create();
        return dialog;
    }
}
