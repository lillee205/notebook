import axios from 'axios'

const NOTEBOOK_API_BASE_URL = "http://localhost:1602/entries"

class NotebookService {
    getEntry(id) {
        return axios.get(`${NOTEBOOK_API_BASE_URL}/${id}`)
    }
    getEntries() {
        return axios.get(NOTEBOOK_API_BASE_URL)
    }
    addEntry(entry) {
        return axios.post(NOTEBOOK_API_BASE_URL, entry)
    }
}

export default new NotebookService()