<template>
    <div>
        <h1>{{ entry.title }}</h1>
        <p>{{ entry.contents }}</p>
    </div>
</template>
<script>

export default {
    name: "NotebookEntry",
    props: {
        entryId: Number,
        entry: Object, 

    }
}
</script>
