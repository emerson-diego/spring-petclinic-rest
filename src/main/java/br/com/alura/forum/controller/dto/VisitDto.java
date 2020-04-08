package br.com.alura.forum.controller.dto;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Visit;

public class VisitDto {

    private Long id;
    private Date date;
    private String description;
    private Long pet;

    public VisitDto() {
    }

    public VisitDto(Visit visit) {
        this.id = visit.getId();
        this.date = visit.getDate();
        this.description = visit.getDescription();
        this.pet = visit.getPet().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPet() {
        return pet;
    }

    public void setPet(Long pet) {
        this.pet = pet;
    }

    public static Collection<VisitDto> converter(Collection<Visit> visits) {
        return visits.stream().map(VisitDto::new).collect(Collectors.toList());
    }

}
