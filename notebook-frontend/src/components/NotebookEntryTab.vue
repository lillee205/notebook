<template>
    <a href="#" class="list-group-item list-group-item-action py-3 lh-tight" aria-current="false">
        <div class="d-flex w-100 align-items-center justify-content-between">
          <strong class="mb-1">{{title}}</strong>
        </div>
        <div class="col-10 mb-1 small">{{contentPreview}}</div>
      </a>
</template>

<script>
export default {
  name: 'NotebookEntryTab',
  props: {
    title: String,
    contents: String
  },
  computed: {
    contentPreview() {
        if (this.contents.length < 30) {
            return this.contents
        } else {
            return (this.contents.slice(0, 30) + "...")
        }
    }
  }

}
</script>
