<template>
    <form 
        @submit.prevent="$event => addEntry()" 
       >
        <div class="form-group">
          <input
            type="text"
            class="form-control"
            ref="entryTitleInput"
            placeholder="Entry title"
          />
        </div>
        <div class="form-group">
          <textarea
            class="form-control"
            ref="entryContentsInput"
            rows="3"
          ></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
</template>
<script>

export default {
  name: "NotebookAddEntry",
  methods: {
      addEntry() {
      const entry = {
              title: this.$refs.entryTitleInput.value,
              contents: this.$refs.entryContentsInput.value,
          };
      this.$emit('add-entry', entry)
      }
  }
}
</script>
