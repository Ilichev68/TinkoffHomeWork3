package com.homework.android.tinkoffhomework3;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements FirstNumber.FirstNumberFragmentListener, SecondNumber.SecondNumberFragmentListener,Operation.OperationFragmentListener {

    private FirstNumber firstNumberFragment;
    private SecondNumber secondNumberFragment;
    private Operation operationFragment;
    private Result result;
    private double firstNumber;
    private double secondNumber;
    private String operation;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFirstFragment();
    }

    public void getFirstFragment(){
        firstNumberFragment = FirstNumber.newInstance();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.container, firstNumberFragment).commit();
        }



    public void getSecondFragment(){
        secondNumberFragment = SecondNumber.newInstance();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.container, secondNumberFragment).commit();
    }

    public void getOperationFragment(){
        operationFragment = Operation.newInstance();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.container, operationFragment).commit();
    }

    public void getResultFragment(){
        if (operation.equals("plus")) {
            double res = firstNumber + secondNumber;
            result = Result.newInstance(res);
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            transaction.replace(R.id.container, result).commit();
        }else if(operation.equals("minus")){
            double res = firstNumber - secondNumber;
            result = Result.newInstance(res);
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            transaction.replace(R.id.container, result).commit();
        }else if (operation.equals("mult")){
            double res = firstNumber * secondNumber;
            result = Result.newInstance(res);
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            transaction.replace(R.id.container, result).commit();
        }else if (operation.equals("div")){
            double res = firstNumber / secondNumber;
            result = Result.newInstance(res);
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            transaction.replace(R.id.container, result).commit();
        }
    }

    @Override
    public void firstNumberCallback(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    @Override
    public void secondNumberCallback(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    @Override
    public void operationCallback(String operation) {
        this.operation = operation;
    }
}
