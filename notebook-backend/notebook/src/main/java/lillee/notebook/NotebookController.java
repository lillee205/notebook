package lillee.notebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class NotebookController {
    @Autowired
    private NotebookRepository notebookRepository;

    @GetMapping(value = "/entries/{entryId}")
    public Entry getEntry(@PathVariable Integer entryId) {
        return notebookRepository.findById(entryId)
                                 .orElse(null);
    }

    @GetMapping(value = "/entries")
    public List<Entry> getAllEntries() {
        List<Entry> entries = new ArrayList<>();
        notebookRepository.findAll().forEach(entries::add);
        return entries;
    }

    @PostMapping(value = "/entries")
    public void addEntry(@RequestBody Entry entry) {
        notebookRepository.save(entry);
    }

    @PutMapping(value = "/entries/{entryId}")
    public void updateEntry(@RequestBody Entry entry, @PathVariable Integer entryId) {
        notebookRepository.save(entry);
    }

    @DeleteMapping(value = "/entries/{entryId}")
    public void deleteEntry(@PathVariable Integer entryId) {
        notebookRepository.deleteById(entryId);
    }
}
