package cr.ac.ucenfotec.cruds.web.rest;

import cr.ac.ucenfotec.cruds.domain.Leadership;
import cr.ac.ucenfotec.cruds.repository.LeadershipRepository;
import cr.ac.ucenfotec.cruds.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link cr.ac.ucenfotec.cruds.domain.Leadership}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class LeadershipResource {

    private final Logger log = LoggerFactory.getLogger(LeadershipResource.class);

    private static final String ENTITY_NAME = "leadership";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final LeadershipRepository leadershipRepository;

    public LeadershipResource(LeadershipRepository leadershipRepository) {
        this.leadershipRepository = leadershipRepository;
    }

    /**
     * {@code POST  /leaderships} : Create a new leadership.
     *
     * @param leadership the leadership to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new leadership, or with status {@code 400 (Bad Request)} if the leadership has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/leaderships")
    public ResponseEntity<Leadership> createLeadership(@Valid @RequestBody Leadership leadership) throws URISyntaxException {
        log.debug("REST request to save Leadership : {}", leadership);
        if (leadership.getId() != null) {
            throw new BadRequestAlertException("A new leadership cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Leadership result = leadershipRepository.save(leadership);
        return ResponseEntity.created(new URI("/api/leaderships/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /leaderships} : Updates an existing leadership.
     *
     * @param leadership the leadership to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated leadership,
     * or with status {@code 400 (Bad Request)} if the leadership is not valid,
     * or with status {@code 500 (Internal Server Error)} if the leadership couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/leaderships")
    public ResponseEntity<Leadership> updateLeadership(@Valid @RequestBody Leadership leadership) throws URISyntaxException {
        log.debug("REST request to update Leadership : {}", leadership);
        if (leadership.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Leadership result = leadershipRepository.save(leadership);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, leadership.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /leaderships} : get all the leaderships.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of leaderships in body.
     */
    @GetMapping("/leaderships")
    public List<Leadership> getAllLeaderships() {
        log.debug("REST request to get all Leaderships");
        return leadershipRepository.findAll();
    }

    /**
     * {@code GET  /leaderships/:id} : get the "id" leadership.
     *
     * @param id the id of the leadership to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the leadership, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/leaderships/{id}")
    public ResponseEntity<Leadership> getLeadership(@PathVariable Long id) {
        log.debug("REST request to get Leadership : {}", id);
        Optional<Leadership> leadership = leadershipRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(leadership);
    }

    /**
     * {@code DELETE  /leaderships/:id} : delete the "id" leadership.
     *
     * @param id the id of the leadership to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/leaderships/{id}")
    public ResponseEntity<Void> deleteLeadership(@PathVariable Long id) {
        log.debug("REST request to delete Leadership : {}", id);
        leadershipRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
