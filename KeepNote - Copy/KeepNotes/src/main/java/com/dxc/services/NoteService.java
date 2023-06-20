package com.dxc.services;

import com.dxc.exception.NoteExistsException;
import com.dxc.model.Note;

public interface NoteService {

	Note newNote(Note note) throws NoteExistsException;

}
