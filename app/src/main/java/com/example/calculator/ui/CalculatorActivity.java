package com.example.calculator.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.R;
import com.example.calculator.domain.CalculatorImp;
import com.example.calculator.domain.Operation;
import com.example.calculator.domain.Theme;
import com.example.calculator.storage.ThemeStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorActivity<container> extends AppCompatActivity implements CalculatorView {

    private TextView txtResult;

    private LinearLayout container;

    private CalculatorPresenter presenter;

    private ThemeStorage storage;

    public CalculatorActivity(LinearLayout container) {
        this.container = container;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        storage = new ThemeStorage(this);
        
        setTheme(storage.getTheme().getTheme());

        setContentView(R.layout.activity_main);

        presenter = new CalculatorPresenter(this, new CalculatorImp());

        txtResult = findViewById(R.id.txt_result);

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.key_0, 0);
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);

        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onDigitPressed(digits.get(v.getId()));
            }
        };

        findViewById(R.id.key_1).setOnClickListener(digitClickListener);
        findViewById(R.id.key_2).setOnClickListener(digitClickListener);
        findViewById(R.id.key_3).setOnClickListener(digitClickListener);
        findViewById(R.id.key_4).setOnClickListener(digitClickListener);
        findViewById(R.id.key_5).setOnClickListener(digitClickListener);
        findViewById(R.id.key_6).setOnClickListener(digitClickListener);
        findViewById(R.id.key_7).setOnClickListener(digitClickListener);
        findViewById(R.id.key_8).setOnClickListener(digitClickListener);
        findViewById(R.id.key_9).setOnClickListener(digitClickListener);
        findViewById(R.id.key_0).setOnClickListener(digitClickListener);

        Map<Integer, Operation> operators = new HashMap<>();
        operators.put(R.id.key_add, Operation.ADD);
        operators.put(R.id.key_sub, Operation.SUB);
        operators.put(R.id.key_div, Operation.DIV);
        operators.put(R.id.key_mul, Operation.MULT);

        View.OnClickListener operationClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onOperationPressed(operators.get(v.getId()));
            }
        };

        findViewById(R.id.key_add).setOnClickListener(operationClickListener);
        findViewById(R.id.key_sub).setOnClickListener(operationClickListener);
        findViewById(R.id.key_div).setOnClickListener(operationClickListener);
        findViewById(R.id.key_mul).setOnClickListener(operationClickListener);

        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDotPressed();
            }
        });


        container = findViewById(R.id.theme_container);

        presenter.requestThemes();

    }

    @Override
    public void showResult(String result) {
        txtResult.setText(result);

    }

    @Override
    public void showThemes(List<Theme> themes) {
        if (container == null) {
            return;
        }

        for (Theme theme: themes){
            View itemView = getLayoutInflater().inflate(R.layout.item_theme, container, false);

            ImageView img = itemView.findViewById(R.id.img);
            TextView txt = itemView.findViewById(R.id.txt);

            img.setImageResource(theme.getImg());

            String textValue = getString(theme.getTitle());
            txt.setText(theme.getTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    storage.setTheme(theme);

                    recreate();
                }
            });

            container.addView(itemView);
        }
    }}
