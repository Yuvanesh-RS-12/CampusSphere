# CampusSphere — Phase 1 + Phase 2 + Phase 3 + Phase 4 + Phase 5

Student Resource Exchange & Collaboration Platform — Java Programming Course Project.

**Phase 1 (Foundation)**, **Phase 2 (Buy & Sell Marketplace)**, **Phase 3 (Freelance Hub)**, **Phase 4 (Senior Guidance Hub)**, and **Phase 5 (Lost & Found Portal)** are complete. All four content modules are now live. Notifications and Admin are **not yet implemented** and will be added in later phases.

## Phase 1 — Foundation (reviewed & fixed)
- **CSRF fix (functional bug):** `/api/**` is now explicitly excluded from CSRF protection, since it is called via `fetch()`/AJAX. CSRF protection remains fully enabled for session-based form submissions (`/login`, `/logout`). Without this fix, registration returned `403 Forbidden` on every attempt.
- Removed two unused/dead files: `UserLoginDTO.java` and `InvalidRequestException.java` (and its now-orphaned handler in `GlobalExceptionHandler`).
- Removed a duplicate default-role assignment in `UserService` (the `User` entity already defaults `role` to `STUDENT`).
- Fixed misplaced Javadoc in `PageController.java`.
- Removed unused `xmlns:sec` namespace declarations from pages that don't use `sec:` attributes.
- Added `UserServiceTest.java` — unit tests for registration (success + duplicate-email rejection) and profile lookup.

## Phase 2 — Buy & Sell Marketplace
- Full CRUD for listings: create, view, edit, delete — restricted to the listing's owner for edit/delete.
- Category filter (Books, Electronics, Calculators, Academic Materials, Other) + keyword search across title/description.
- Item condition, price, contact info, and status (Available/Reserved/Sold) tracking.
- Local image upload (JPG/PNG, up to 5MB) via a shared `FileStorageService` (reusable by future modules), served from `/uploads/**`.
- "My Listings" page for managing a student's own posting history regardless of status.
- Dashboard and navbar now link to the live Marketplace module.

**New dependency-free integration points (4 existing files touched, nothing else):**
1. `application.properties` — added `campussphere.upload.dir` + multipart size limits
2. `SecurityConfig.java` — added `/uploads/**` to the public (`permitAll`) resource list
3. `fragments/navbar.html` — added a "Marketplace" link for authenticated users
4. `dashboard.html` + `style.css` — Marketplace card is now a live link instead of a "Coming in Phase 2" placeholder

## Phase 3 — Freelance Hub
- Full CRUD for service postings: create, view, edit, delete — restricted to the posting's owner for edit/delete, enforced in the service layer (not just hidden in the UI) and covered by a unit test.
- Category filter (Record Writing, PPT Creation, Poster Design, Resume Design, Coding Help, Assignment Help, Video Editing, Graphic Design, UI/UX Design, Other) + keyword search across title/description.
- Fixed or "starting from" pricing, contact info, and a 3-state availability status (Available/Busy/Not Accepting) editable by the owner.
- Optional sample-work image upload, reusing the same `FileStorageService` from Phase 2 - stored under `uploads/freelance/`, no new configuration needed.
- "My Services" page for managing a student's own posting history regardless of status.
- Dashboard and navbar now link to the live Freelance Hub module.
- Business logic class is named `FreelanceServiceManager`, not `FreelanceServiceService` - the entity is already named `FreelanceService`, so the strict `[Entity]Service` naming convention used elsewhere would produce an ambiguous double-"Service" name next to Spring's own `@Service` stereotype.
- No `freelance.js` was added - `marketplace.js` only provides an optional image-preview nicety, not required for the upload to function, so duplicating it wasn't justified.

**Integration points touched (2 existing files, nothing else - no `SecurityConfig` or `application.properties` changes were needed since Freelance reuses the existing `/uploads/**` rule and `FileStorageService` as-is):**
1. `fragments/navbar.html` — added a "Freelance Hub" link for authenticated users
2. `dashboard.html` — Freelance Hub card is now a live link instead of a "Coming Soon" placeholder

## Phase 4 — Senior Guidance Hub
- Full CRUD for guidance posts: create, view, edit, delete — restricted to the author for edit/delete, enforced in the service layer and covered by a unit test, same as the other two modules.
- Category filter (Internship Guidance, Placement Preparation, Subject Guidance, Hackathon Guidance, Career Advice, Certification Guidance, Higher Studies, Other) + keyword search across title/description.
- Optional targeting metadata (relevant year, relevant department) so a post can flag itself as most useful to a specific audience, distinct from the author's own profile year/department.
- Two-state visibility (Published/Hidden) editable by the author - simpler than Marketplace's 3-state status or Freelance's 3-state availability, since a guidance post doesn't have a transactional lifecycle to track.
- Optional attachment upload, reusing the same `FileStorageService` from Phase 2/3 - stored under `uploads/guidance/`, no new configuration needed.
- "My Guidance Posts" page for managing an author's full posting history regardless of visibility.
- Dashboard and navbar now link to the live Senior Guidance Hub module.
- Business logic class named `GuidanceServiceManager`, matching `FreelanceServiceManager`'s "Manager" naming precedent for consistency across sibling modules, even though the entity here (`GuidancePost`) doesn't itself force the naming collision that motivated `FreelanceServiceManager`'s name.
- No `guidance.js` was added, for the same reasoning as Phase 3's `freelance.js` decision - no essential functionality depends on client-side JS here.

**Integration points touched (2 existing files, nothing else - `SecurityConfig` and `application.properties` confirmed byte-identical to Phase 3, no changes needed):**
1. `fragments/navbar.html` — added a "Senior Guidance" link for authenticated users
2. `dashboard.html` — Senior Guidance card is now a live link instead of a "Coming Soon" placeholder

## Phase 5 — Lost & Found Portal
- Full CRUD for lost/found posts: create, view, edit, delete — restricted to the owner for edit/delete, enforced in the service layer and covered by a unit test, same as every other module.
- Post-type filter (Lost/Found), category filter (ID Card, Book, Bag, Mobile, Laptop, Calculator, Keys, Wallet, Accessory, Other), and keyword search across title/description, all combined into a single flexible repository query.
- **Deliberately different browsing behavior from the other three modules:** browsing defaults to OPEN posts only, but a status can be explicitly requested to see CLAIMED or CLOSED posts too (e.g. "was this already claimed?"). Marketplace/Freelance/Guidance always hide their non-active state from public browsing; Lost & Found intentionally allows looking these up, since that has real value for this specific use case. This is documented directly in `LostFoundPostRepository`.
- Location and date-lost/date-found fields, using a native HTML `<input type="date">` bound to `LocalDate` via `@DateTimeFormat(pattern = "yyyy-MM-dd")`.
- Optional item photo upload, reusing the same `FileStorageService` from Phase 2/3/4 - stored under `uploads/lostfound/`, no new configuration needed.
- "My Posts" page for managing an owner's full reporting history regardless of status.
- Dashboard and navbar now link to the live Lost & Found module - **all four content modules are now live.**
- Business logic class named `LostFoundServiceManager`, consistent with the "Manager" naming precedent set by `FreelanceServiceManager` and `GuidanceServiceManager`.
- No `lostfound.js` was added - the post-type picker uses Bootstrap's pure-CSS button-group/radio pattern, no JavaScript required.
- One bug caught and fixed during development: an early draft of `lostfound/form.html` used the HTML5 `<template>` tag to wrap a `th:each` loop for the Lost/Found radio picker. `<template>` content is inert in browsers (never rendered without JavaScript to clone it) - this would have made the radio buttons silently never appear. Replaced with Thymeleaf's `th:block`, which is stripped from the rendered output but correctly supports `th:each` without introducing an extra DOM element.

**Integration points touched (2 existing files, nothing else - `SecurityConfig` and `application.properties` confirmed byte-identical to Phase 4, no changes needed):**
1. `fragments/navbar.html` — added a "Lost & Found" link for authenticated users
2. `dashboard.html` — Lost & Found card is now a live link instead of a "Coming Soon" placeholder

## Prerequisites

- Java 17 (JDK)
- Maven 3.9+
- MySQL 8.x running locally

## Setup

1. Create a MySQL user/password with access to create databases, or ensure `campussphere_db` can be created automatically.
2. Open `src/main/resources/application.properties` and update:
   - `spring.datasource.username`
   - `spring.datasource.password`
   - `campussphere.security.allowed-email-domain` (set to your institution's actual email domain)
3. From the project root, run:
   ```
   mvn spring-boot:run
   ```
4. Visit `http://localhost:8080`.

## What works (Phase 1 + Phase 2 + Phase 3 + Phase 4 + Phase 5)

| Feature | Route |
|---|---|
| Landing page | `GET /` |
| Registration page | `GET /register` |
| Registration API | `POST /api/auth/register` |
| Login page | `GET /login` |
| Login (Spring Security form login) | `POST /login` |
| Logout | `POST /logout` |
| Post-login dashboard | `GET /dashboard` |
| Current user info | `GET /api/auth/me` (requires authentication) |
| Marketplace home (browse/search/filter) | `GET /marketplace?category=&keyword=` |
| My Listings | `GET /marketplace/my-listings` |
| View listing detail | `GET /marketplace/{id}` |
| Create listing form / submit | `GET`/`POST /marketplace/create` |
| Edit listing form / submit | `GET`/`POST /marketplace/{id}/edit` (owner only) |
| Delete listing | `POST /marketplace/{id}/delete` (owner only) |
| Uploaded listing images | `GET /uploads/marketplace/{filename}` |
| Freelance Hub home (browse/search/filter) | `GET /freelance?category=&keyword=` |
| My Services | `GET /freelance/my-services` |
| View service detail | `GET /freelance/{id}` |
| Create service form / submit | `GET`/`POST /freelance/create` |
| Edit service form / submit | `GET`/`POST /freelance/{id}/edit` (owner only) |
| Delete service | `POST /freelance/{id}/delete` (owner only) |
| Uploaded sample images | `GET /uploads/freelance/{filename}` |
| Guidance Hub home (browse/search/filter) | `GET /guidance?category=&keyword=` |
| My Guidance Posts | `GET /guidance/my-guidance` |
| View guidance post detail | `GET /guidance/{id}` |
| Create guidance form / submit | `GET`/`POST /guidance/create` |
| Edit guidance form / submit | `GET`/`POST /guidance/{id}/edit` (owner only) |
| Delete guidance post | `POST /guidance/{id}/delete` (owner only) |
| Uploaded guidance attachments | `GET /uploads/guidance/{filename}` |
| Lost & Found home (browse/search/filter) | `GET /lostfound?postType=&category=&status=&keyword=` |
| My Posts | `GET /lostfound/my-posts` |
| View post detail | `GET /lostfound/{id}` |
| Create post form / submit | `GET`/`POST /lostfound/create` |
| Edit post form / submit | `GET`/`POST /lostfound/{id}/edit` (owner only) |
| Delete post | `POST /lostfound/{id}/delete` (owner only) |
| Uploaded item photos | `GET /uploads/lostfound/{filename}` |

## Project Structure

```
com.campussphere
├── config/            → SecurityConfig, WebMvcConfig
├── common/
│   ├── dto/             → ApiResponse
│   ├── exception/         → custom exceptions + GlobalExceptionHandler
│   ├── service/            → FileStorageService (shared, reusable by future modules)
│   └── util/               → college email validation
├── auth/
│   ├── entity/          → User, Role
│   ├── repository/        → UserRepository
│   ├── dto/                 → UserRegisterDTO, UserProfileDTO
│   ├── service/               → UserService, CustomUserDetailsService
│   └── controller/              → AuthController, PageController
└── marketplace/
    ├── entity/          → MarketplaceListing, ListingCategory, ListingCondition, ListingStatus
    ├── repository/        → MarketplaceListingRepository
    ├── dto/                 → CreateDTO, UpdateDTO, ResponseDTO
    ├── service/               → MarketplaceListingService
    └── controller/              → MarketplaceController
```

```
com.campussphere.freelance
├── entity/          → FreelanceService, ServiceCategory, PriceType, AvailabilityStatus
├── repository/        → FreelanceServiceRepository
├── dto/                 → CreateDTO, UpdateDTO, ResponseDTO
├── service/               → FreelanceServiceManager
└── controller/              → FreelanceController
```

```
com.campussphere.guidance
├── entity/          → GuidancePost, GuidanceCategory, VisibilityStatus
├── repository/        → GuidancePostRepository
├── dto/                 → CreateDTO, UpdateDTO, ResponseDTO
├── service/               → GuidanceServiceManager
└── controller/              → GuidanceController
```

```
com.campussphere.lostfound
├── entity/          → LostFoundPost, ItemCategory, PostType, PostStatus
├── repository/        → LostFoundPostRepository
├── dto/                 → LostFoundCreateDTO, LostFoundUpdateDTO, LostFoundResponseDTO
├── service/               → LostFoundServiceManager
└── controller/              → LostFoundController
```

## Next Phase

Phase 6 will add the Notification Center (cross-cutting, consumed by all four content modules) and the Admin Module (user management, listing moderation, report resolution). See the Master Project Blueprint for full roadmap details.
