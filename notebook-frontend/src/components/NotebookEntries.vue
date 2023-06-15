<template>
  <div class="container" style="display: flex">
    <div
      class="d-flex flex-column align-items-stretch flex-shrink-0 bg-white"
      style="width: 1000px"
    >
      <NotebookEntry
        v-show="!showAddEntry"
        :entryId="currentEntryId"
        :entry="currentEntry"
      >
      </NotebookEntry>
      <NotebookAddEntry 
        @add-entry="addEntry" 
        v-show="showAddEntry">
      </NotebookAddEntry>
    </div>
    <div
      class="d-flex flex-column align-items-stretch flex-shrink-0 bg-white"
      style="width: 400px"
    >
      <a
        class="d-flex align-items-center flex-shrink-0 p-3 link-dark text-decoration-none border-bottom"
      >
        <span class="fs-5 fw-semibold">List group</span>
        <button class="btn btn-primary" @click="switchToAddEntry">
          Add entry
        </button>
      </a>
      <div class="list-group list-group-flush border-bottom scrollarea">
        <NotebookEntryTab
          v-for="entry in entries"
          :key="entry.id"
          :title="entry.title"
          :contents="entry.contents"
          @click="switchToShowEntry(entry.id)"
        />
      </div>
    </div>
  </div>
</template>

<script>
import NotebookService from "../services/NotebookService";
import NotebookEntryTab from "../components/NotebookEntryTab.vue";
import NotebookEntry from "../components/NotebookEntry.vue";
import NotebookAddEntry from "../components/NotebookAddEntry.vue";
export default {
  name: "NotebookEntries",
  components: { NotebookEntryTab, NotebookEntry, NotebookAddEntry },
  data() {
    return {
      entries: [],
      count: 0,
      showAddEntry: false,
      currentEntryId: -1,
      currentEntry: {
        id: -1,
        title: "",
        contents: "",
      },
    };
  },
  watch: {
    currentEntryId() {
      this.getEntry(this.currentEntryId);
    },
  },
  methods: {
    getEntry(id) {
      NotebookService.getEntry(id).then((response) => {
        this.currentEntry = response.data;
      });
    },
    getEntries() {
      NotebookService.getEntries().then((response) => {
        this.entries = response.data;
      });
    },
    switchToAddEntry() {
      this.showAddEntry = true;
    },
    switchToShowEntry(id) {
      this.showAddEntry = false;
      this.currentEntryId = id;
    },
    addEntry(entry) {
      NotebookService.addEntry(entry).then(() => {
        this.getEntries();
      });
    },
  },
  created() {
    this.getEntries();
  },
};
</script>
