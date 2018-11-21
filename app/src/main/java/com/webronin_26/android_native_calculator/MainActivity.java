package com.webronin_26.android_native_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {

        System.loadLibrary("native-lib");

    }

    @BindView( R.id.textView )
    AppCompatTextView textView;

    private StringBuilder firstNumberStringBuilder = null;

    private StringBuilder secondNumberStringBuilder = null;

    private long result = 0L;

    private boolean switchTarget = false;

    private int currentOperator = 0;

    private final int PLUS = 1;

    private final int MINUS = 2;

    private final int MULTIPLIED = 3;

    private final int DIVIDE = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        ButterKnife.bind( this );

        initData();

    }

    private void initData(){

        firstNumberStringBuilder = new StringBuilder();

        secondNumberStringBuilder = new StringBuilder();

    }

    public native long plusIntFromJNI( int number1 , int number2 );

    public native long minusIntFromJNI( int number1 , int number2 );

    public native long multipliedIntFromJNI( int number1 , int number2 );

    public native long dividedIntFromJNI( int number1 , int number2 );

    private void showOnTextView( String string ){

        textView.setText( string );

    }

    private void firstStringCalculate( String string ){

        if( firstNumberStringBuilder.length() < 9 ){

            firstNumberStringBuilder.append( string );

            showOnTextView( firstNumberStringBuilder.toString() );

        }

    }

    private void secoundStringCalculate( String string ){

        if( secondNumberStringBuilder.length() < 9 ){

            secondNumberStringBuilder.append( string );

            showOnTextView( secondNumberStringBuilder.toString() );

        }

    }

    @OnClick( R.id.bt00 )
    public void bt00Click(){

        if( !switchTarget ){

            firstStringCalculate( "0" );

        }else {

            secoundStringCalculate( "0" );

        }

    }

    @OnClick( R.id.bt01 )
    public void bt01Click(){

        if( !switchTarget ){

            firstStringCalculate( "1" );

        }else {

            secoundStringCalculate( "1" );

        }

    }

    @OnClick( R.id.bt02 )
    public void bt02Click(){

        if( !switchTarget ){

            firstStringCalculate( "2" );

        }else {

            secoundStringCalculate( "2" );

        }

    }

    @OnClick( R.id.bt03 )
    public void bt03Click(){

        if( !switchTarget ){

            firstStringCalculate( "3" );

        }else {

            secoundStringCalculate( "3" );

        }

    }

    @OnClick( R.id.bt04 )
    public void bt04Click(){

        if( !switchTarget ){

            firstStringCalculate( "4" );

        }else {

            secoundStringCalculate( "4" );

        }

    }

    @OnClick( R.id.bt05 )
    public void bt05Click(){

        if( !switchTarget ){

            firstStringCalculate( "5" );

        }else {

            secoundStringCalculate( "5" );

        }

    }

    @OnClick( R.id.bt06 )
    public void bt06Click(){

        if( !switchTarget ){

            firstStringCalculate( "6" );

        }else {

            secoundStringCalculate( "6" );

        }

    }

    @OnClick( R.id.bt07 )
    public void bt07Click(){

        if( !switchTarget ){

            firstStringCalculate( "7" );

        }else {

            secoundStringCalculate( "7" );

        }

    }

    @OnClick( R.id.bt08 )
    public void bt08Click(){

        if( !switchTarget ){

            firstStringCalculate( "8" );

        }else {

            secoundStringCalculate( "8" );

        }

    }

    @OnClick( R.id.bt09 )
    public void bt09Click(){

        if( !switchTarget ){

            firstStringCalculate( "9" );

        }else {

            secoundStringCalculate( "9" );

        }

    }

    @OnClick( R.id.bt_divided )
    public void bt_dividedClick() {

        if( secondNumberStringBuilder.length() > 0 ) {

            // do nothing

        }else {

            if( firstNumberStringBuilder.length() > 0 ) {

                switchTarget = true;

                currentOperator = DIVIDE;

            }

        }

    }

    @OnClick( R.id.bt_minus )
    public void bt_minusClick(){

        if( secondNumberStringBuilder.length() > 0 ) {

            // do nothing

        }else {

            if( firstNumberStringBuilder.length() > 0 ) {

                switchTarget = true;

                currentOperator = MINUS;

            }

        }

    }

    @OnClick( R.id.bt_multiplied )
    public void bt_multipliedClick(){

        if( secondNumberStringBuilder.length() > 0 ) {

            // do nothing

        }else {

            if( firstNumberStringBuilder.length() > 0 ) {

                switchTarget = true;

                currentOperator = MULTIPLIED;

            }

        }

    }

    @OnClick( R.id.bt_pluse )
    public void bt_pluseClick(){

        if( secondNumberStringBuilder.length() > 0 ) {

            // do nothing

        }else {

            if( firstNumberStringBuilder.length() > 0 ) {

                switchTarget = true;

                currentOperator = PLUS;

            }

        }

    }

    @OnClick( R.id.bt_equals )
    public void bt_equalsClick(){

        if( firstNumberStringBuilder.length() > 0 && secondNumberStringBuilder.length() > 0 ) {

            switch ( currentOperator ) {

                case PLUS:
                    result = plusIntFromJNI(
                            Integer.parseInt( firstNumberStringBuilder.toString() )
                            , Integer.parseInt( secondNumberStringBuilder.toString() ));
                    break;

                case MINUS:
                    result = minusIntFromJNI(
                            Integer.parseInt( firstNumberStringBuilder.toString() )
                            , Integer.parseInt( secondNumberStringBuilder.toString() ));
                    break;

                case MULTIPLIED:
                    result = multipliedIntFromJNI(
                            Integer.parseInt( firstNumberStringBuilder.toString() )
                            , Integer.parseInt( secondNumberStringBuilder.toString() ));
                    break;

                case DIVIDE:
                    result = dividedIntFromJNI(
                            Integer.parseInt( firstNumberStringBuilder.toString() )
                            , Integer.parseInt( secondNumberStringBuilder.toString() ));

            }

            showOnTextView( result + "" );

            result = 0L;

            switchTarget = false;

            currentOperator = 0;

            firstNumberStringBuilder.setLength( 0 );

            secondNumberStringBuilder.setLength( 0 );

        }

    }

}
