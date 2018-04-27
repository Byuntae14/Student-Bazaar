package com.example.william.studentbazaar.TradeDirectory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
//import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.william.studentbazaar.R;

/**
 * Created by Michelle Dinh on 4/23/2018.
 */

public class SellItemForm extends AppCompatActivity {

    private Button mSubmitButton;
    private EditText mItemName;
    private EditText mItemDescription;
    private EditText mItemPrice;
    private String itemName;
    private String itemDescription;
    private Float itemPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_sellitemform);
        itemName = "";
        itemDescription = "";
        mSubmitButton = findViewById(R.id.submit_button);

        mItemName = findViewById(R.id.name_edit_text);
        mItemName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                itemName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mItemDescription = findViewById(R.id.description_edit_text);
        mItemDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                itemDescription = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mItemPrice = findViewById(R.id.price_edit_text);
        itemPrice = Float.parseFloat(mItemPrice.getText().toString());

//        mSubmitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//            }
//        });



    }
}
