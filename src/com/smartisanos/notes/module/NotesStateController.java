
package com.smartisanos.notes.module;

import com.smartisanos.notes.module.NotesStateMachine.STATES;
import com.smartisanos.notes.state.IState;

public interface NotesStateController {
    public abstract void transToState(STATES states);

    public abstract void quite();

    public abstract IState getCurrentState();
}
