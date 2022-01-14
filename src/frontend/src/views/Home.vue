<template>
  <div class="home">
    <NoteForm />
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import NoteForm from '@/components/NoteForm.vue'; // @ is an alias to /src

export default defineComponent({
  name: 'Home',
  components: {
    NoteForm
  },
});
</script>

<style scoped>
.home {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
