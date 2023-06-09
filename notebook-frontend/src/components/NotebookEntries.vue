<template>
    <div class = "container" style="display:flex;">
        <div class ="d-flex flex-column align-items-stretch flex-shrink-0 bg-white" style="width: 1000px;">
            <form @submit.prevent="addEntry()">
                <div class="form-group">
                    <input type="text" class="form-control" ref="entryTitleInput" placeholder="Entry title">
                </div>
                <div class="form-group">
                    <textarea class="form-control" ref="entryContentsInput" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>         
        </div>   
        <div class ="d-flex flex-column align-items-stretch flex-shrink-0 bg-white" style="width: 400px;">
            <a class="d-flex align-items-center flex-shrink-0 p-3 link-dark text-decoration-none border-bottom">
                <span class="fs-5 fw-semibold">List group</span>
            </a>
            <div class="list-group list-group-flush border-bottom scrollarea">
                <EntryTab 
                    v-for="entry in entries"
                    :key="entry.id" 
                    :title="entry.title"
                    :contents="entry.contents"
                />
            </div>
        </div>
    </div>
    
</template>

<script>

import NotebookService from '../services/NotebookService';
import EntryTab from "../components/EntryTab.vue";

export default {
    name: 'NotebookEntries',
    components: { EntryTab },
    data(){
        return {
            entries: [],
            count: 0
        }
    },
    methods: {
        getEntries() {
            NotebookService.getEntries()
                .then((response) => {
                    this.entries = response.data;   
                    console.log(this.entries)
            });
        },
        addEntry() {
            const entry = {
                title: this.$refs.entryTitleInput.value,
                contents: this.$refs.entryContentsInput.value
            }
            NotebookService.addEntry(entry)
                .then(() => {
                    this.getEntries()
                })
        }
    },
    created() {
        this.getEntries();
    }
}

</script>