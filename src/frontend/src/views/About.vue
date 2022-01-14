<template>
  <div class="about">
    <div class="col-8">
      <table class="table table-success table-striped">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">Content</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(note, index) in notesList" :key="index">
            <th scope="row">{{ index }}</th>
            <td>{{ note.title }}</td>
            <td>{{ note.content }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from "vue";

import useNotes, { Note } from "@/modules/notes";

export default defineComponent({
  name: 'NotesList',

  setup() {
    const notesList = ref<Array<Note>>(useNotes().allNotes)

    const getAllNotes = () => useNotes().all();

    return { notesList, getAllNotes }
  },

  mounted() {
    this.getAllNotes();
  }
})
</script>

<style scoped>
.about {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
