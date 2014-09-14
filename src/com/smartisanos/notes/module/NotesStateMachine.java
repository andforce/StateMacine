
package com.smartisanos.notes.module;

import com.smartisanos.notes.state.IState;
import com.smartisanos.notes.state.State;
import com.smartisanos.notes.state.StateMachine;

import android.content.Context;
import android.os.Message;
import android.util.Log;

public class NotesStateMachine extends StateMachine {
    private static final String TAG = "NotesStateMachine";
    private static final boolean DEBUG = true;

    private NotesState mDefState = new DefState();
    private NotesState mEditState = new EditState();
    private NotesState mCreateState = new CreateState();
    private NotesState mShowNoteState = new ShowNoteState();

    private NotesStateChangeListener mChangeListener;

    public static enum STATES {
        // enum name must be as same as NoteSate class name
        DefState,
        EditState,
        CreateState,
        ShowNoteState
    };

    public static final int TRANSLATE = 0x1000;
    public static final int QUITE = 0x1001;

    public NotesStateMachine(Context context, NotesStateChangeListener listener) {
        super(TAG);
        this.mChangeListener = listener;
        addState(mDefState);
        addState(mShowNoteState);
        addState(mEditState);
        addState(mCreateState);

        setInitialState(mDefState);
        this.start();
    }

    private void debugLog(IState iState, String msg) {
        if (DEBUG) {
            Log.d(TAG + ": " + iState.getName(), msg);
        }
    }

    private void transToState(STATES states) {
        switch (states) {
            case DefState: {
                transitionTo(mDefState);
                break;
            }
            case EditState: {
                transitionTo(mEditState);
                break;
            }
            case CreateState: {
                transitionTo(mCreateState);
                break;
            }
            case ShowNoteState: {
                transitionTo(mShowNoteState);
                break;
            }
        }
    }

    public IState getCurrentNotesState() {
        return getCurrentState();
    }

    abstract class NotesState extends State {

        public abstract void pause();

        public abstract void resume();

        public abstract void destory();

        @Override
        public boolean processMessage(Message msg) {

            switch (msg.what) {
                case QUITE: {
                    quit();
                    break;
                }
                case TRANSLATE: {
                    transToState((STATES) (msg.obj));
                    break;
                }
            }

            return super.processMessage(msg);
        }
    }

    class DefState extends NotesState {

        @Override
        public void enter() {

            mChangeListener.onStateEnter();
            debugLog(this, "enter");
        }

        @Override
        public void exit() {

            mChangeListener.onStateExit();
            debugLog(this, "exit");
        }

        @Override
        public boolean processMessage(Message msg) {

            debugLog(this, "processMessage");

            return super.processMessage(msg);
        }

        @Override
        public void pause() {

            mChangeListener.onStatePause();
        }

        @Override
        public void resume() {

            mChangeListener.onStateResume();
        }

        @Override
        public void destory() {

            mChangeListener.onStateDestory();
        }
    }

    class ShowNoteState extends NotesState {

        @Override
        public void enter() {

            debugLog(this, "enter");
            mChangeListener.onStateEnter();
        }

        @Override
        public void exit() {

            mChangeListener.onStateExit();
            debugLog(this, "exit");
        }

        @Override
        public boolean processMessage(Message msg) {

            debugLog(this, "processMessage");
            return super.processMessage(msg);
        }

        @Override
        public void pause() {

            mChangeListener.onStatePause();
        }

        @Override
        public void resume() {

            mChangeListener.onStateResume();
        }

        @Override
        public void destory() {

            mChangeListener.onStateDestory();
        }

    }

    class EditState extends NotesState {

        @Override
        public void enter() {

            mChangeListener.onStateEnter();
            debugLog(this, "enter");
        }

        @Override
        public void exit() {

            mChangeListener.onStateExit();
            debugLog(this, "exit");
        }

        @Override
        public boolean processMessage(Message msg) {

            debugLog(this, "processMessage");
            return super.processMessage(msg);
        }

        @Override
        public void pause() {

            mChangeListener.onStatePause();
        }

        @Override
        public void resume() {

            mChangeListener.onStateResume();
        }

        @Override
        public void destory() {

            mChangeListener.onStateDestory();
        }

    }

    class CreateState extends NotesState {

        @Override
        public void enter() {

            debugLog(this, "enter");
        }

        @Override
        public void exit() {

            debugLog(this, "exit");
        }

        @Override
        public boolean processMessage(Message msg) {

            debugLog(this, "processMessage");
            return super.processMessage(msg);
        }

        @Override
        public String getName() {

            return super.getName();
        }

        @Override
        public void pause() {

        }

        @Override
        public void resume() {

        }

        @Override
        public void destory() {

        }

    }

}
