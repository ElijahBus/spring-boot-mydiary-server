<template>
  <div class="col-6 p-3">
    <div class="mb-3">
      <label for="title" class="form-label w-100 text-left">Title</label>
      <input type="email" class="form-control" id="title" placeholder="Title here" v-model="title" />
    </div>
    <div class="mb-3">
      <label for="content" class="form-label w-100 text-left">Content</label>
      <textarea class="form-control" id="content" rows="3" v-model="content"></textarea>
    </div>

    <div class="mb-3">
      <button class="btn btn-outline-success form-control" @click="saveNote">Save Note</button>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from "@vue/runtime-core";

// Project level modules
import useNotes from '@/modules/notes';

export default defineComponent({
  name: 'NoteForm',

  setup() {
    const note = useNotes().newNote;

    const title = ref<string>(note.title);
    const content = ref<string>(note.content);

    // Handle the save note event
    function saveNote() {
      useNotes().save({ title: title.value, content: content.value });
    }

    return { title, content, saveNote };
  }
})
</script>

<style>
</style>