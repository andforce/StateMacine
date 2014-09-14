
package com.smartisanos.notes.machine;

import com.smartisanos.notes.module.NotesModule;
import com.smartisanos.notes.module.NotesStateController;
import com.smartisanos.notes.module.NotesStateMachine.STATES;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
    private NotesModule mNotesModule;
    private NotesStateController mController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNotesModule = new NotesModule(this);
        mController = mNotesModule;
        findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mController.transToState(STATES.CreateState);
                //mController.quite();
            }
        });
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        mNotesModule.onStateResume();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        mNotesModule.onStatePause();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        mNotesModule.onStateDestory();
    }

}
