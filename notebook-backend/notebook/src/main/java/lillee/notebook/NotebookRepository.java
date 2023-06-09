package lillee.notebook;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotebookRepository extends JpaRepository<Entry, Integer> {
}
