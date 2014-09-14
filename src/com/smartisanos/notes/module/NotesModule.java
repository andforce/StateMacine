
package com.smartisanos.notes.module;

import com.smartisanos.notes.module.NotesStateMachine.STATES;
import com.smartisanos.notes.state.IState;

import android.app.Activity;
import android.os.Message;
import android.util.Log;

public class NotesModule implements NotesController, NotesStateChangeListener, NotesStateController {
    public static final boolean DEBUG = true;
    public static final String TAG = "NotesModule ";
    private Activity mActivity;
    private NotesUI mNotesUI;
    private NotesStateMachine mNotesStateMachine;

    public NotesModule(Activity activity) {
        this.mActivity = activity;
        mNotesStateMachine = new NotesStateMachine(mActivity.getApplicationContext(), this);
        mNotesUI = new NotesUI(mActivity);
    }

    public NotesStateMachine getMachine() {
        return mNotesStateMachine;
    }

    @Override
    public void saveNote() {

    }

    @Override
    public void deleteNote() {

    }

    @Override
    public void shareNote() {

    }

    @Override
    public void showNote() {

    }

    @Override
    public void onStateEnter() {

        debugLog("onStateEnter");
    }

    @Override
    public void onStateExit() {

        debugLog("onStateExit");

    }

    @Override
    public void onStatePause() {

        debugLog("onStatePause");
    }

    @Override
    public void onStateResume() {

        debugLog("onStateResume");
    }

    @Override
    public void onStateDestory() {

        debugLog("onStateDestory");
    }

    private void debugLog(String msg) {
        if (DEBUG) {
            Log.d(TAG + getCurrentState().getName(), msg);
        }
    }

    @Override
    public void transToState(STATES states) {

        if (states.toString().equals(getCurrentState().getName())) {
            return;
        }
        Message message = new Message();
        message.obj = states;
        message.what = NotesStateMachine.TRANSLATE;
        mNotesStateMachine.sendMessage(message);
    }

    @Override
    public void quite() {

        Message message = new Message();
        message.what = NotesStateMachine.QUITE;
        mNotesStateMachine.sendMessage(message);
    }

    @Override
    public IState getCurrentState() {

        return mNotesStateMachine.getCurrentNotesState();
    }
}
