import axios from "axios";

export interface Note {
  title: string;
  content: string;
}

export type NoteHook = {
  newNote: Note,
  allNotes: Array<Note>,

  save: (note: Note) => void,
  all: () => void,

  error: unknown,
}

export default function useNotes(): NoteHook {
  let newNote: Note = { title: '', content: '' };
  let allNotes: Array<Note> = []

  let error: unknown = null;

  newNote = { title: '', content: '' }

  const save = (note: Note) => {
    fetch('http://localhost:8082/api/v1/notes', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json', 'Accept': 'application/json' },
      body: JSON.stringify(note)
    })
      .then(res => console.log(JSON.stringify(res.body)))
      .catch(err => error = err);
  }

  const all = () => {
    axios.get('http://localhost:8082/api/v1/notes')
      .then(res => allNotes = res.data)
      .catch(err => error = err)
  }

  return { newNote, allNotes, save, all, error };
} 
