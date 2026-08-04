package com.campussphere.auth.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Core identity entity for CampusSphere. Every other module (Listing,
 * Interaction, Review, Notification, Report - added in later phases)
 * relates back to this entity as the "owner" or "actor" of an action.
 *
 * Kept intentionally minimal in Phase 1: only what is required for
 * authentication and basic profile display. Additional profile fields
 * (bio, avatar, contact preferences) can be added in Phase 2 without
 * breaking this structure.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String department;

    @Column(nullable = false)
    private Integer yearOfStudy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role = Role.STUDENT;

    /**
     * Whether the user has completed college-email verification.
     * Set to true immediately at registration for Phase 1 (domain-based
     * check only). A full email-confirmation-link workflow can be
     * layered on top of this flag in a later phase without any schema change.
     */
    @Column(nullable = false)
    private boolean verified = false;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public User() {
    }

    public User(String fullName, String email, String password, String department, Integer yearOfStudy) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.department = department;
        this.yearOfStudy = yearOfStudy;
    }

    // ---------- Getters and Setters ----------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
