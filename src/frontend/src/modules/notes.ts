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

  const headers = {
    "Authorization": "Basic dXNlcjpkNjM2MGE0NS01NmU3LTRmZTAtYmZiZC01MjE5OTNjMjY4ZjQ=",
    "Access-Control-Allow-Origin": "*"
  }

  const save = (note: Note) => {
    axios.post('http://localhost:8082/api/v1/notes', note, { headers })
      .then(res => newNote = res.data)
      .catch(err => error = err);
  }

  const all = () => {
    axios.get('http://localhost:8082/api/v1/notes', { headers })
      .then(res => allNotes = res.data)
      .catch(err => error = err)
  }

  return { newNote, allNotes, save, all, error };
} 
