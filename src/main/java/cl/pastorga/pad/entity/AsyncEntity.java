package cl.pastorga.pad.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "ASYNC_ENTITY")
@Entity
public class AsyncEntity {

    @Id
    @Column(name = "PK_ASYNC_ENTITY")
    @SequenceGenerator(name="SEQ_GEN", sequenceName="SEQ_JUST_FOR_TEST", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
    private long asyncEntityPk;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MODIFIED_ON")
    private Instant modifiedOn;

    public AsyncEntity() {
    }

    public AsyncEntity(String name) {
        this.name = name;
    }

    public long getAsyncEntityPk() {
        return asyncEntityPk;
    }

    public void setAsyncEntityPk(long asyncEntityPk) {
        this.asyncEntityPk = asyncEntityPk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Instant modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @PrePersist
    public void prePersistValues() {
        this.modifiedOn = Instant.now();
    }
}
