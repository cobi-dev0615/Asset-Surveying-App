# Client Responses — Week 1

**Date:** 2026-02-13
**Client contact:** Alan Villegas (avillegas@seretail.com.mx)

---

## Business Context

| Question | Answer |
|----------|--------|
| How many branches/locations? | They are a **supplier to multiple companies**. Need **unlimited company creation**. Branches are per-company. |
| How many fixed assets total? | ~**70,000 per company** |
| How many products in inventory? | **2,000 to 100,000** per branch (varies) |
| Simultaneous Android users (Fixed Assets)? | **10 handhelds** |
| Simultaneous Android users (Inventory)? | **30+ connected users** |
| Web platform users? | **50+ users** in different roles |

### Architecture Implications

- **Multi-tenant system** — each company is a separate tenant with its own assets, branches, users
- **High volume** — 70K assets per company, up to 100K products per branch
- **High concurrency** — 30+ mobile devices syncing simultaneously
- **Scale** — 50+ web users with different roles

---

## Branding

| Question | Answer |
|----------|--------|
| App name / domain | **app.seretail.com.mx** |
| Logo | Client attached files |
| Brand colors | White to black (grayscale). Color for buttons. Open to innovative proposals. |
| Language | **Spanish only** (for now) |

### Color Reference

The client pointed to the existing app at activofijo.seretail.com.mx as a color example, but is open to new proposals.

---

## Sample Data Files

| File | Purpose |
|------|---------|
| `ALFREDO DEL MAZO.xlsx` | Fixed asset catalog example (Alfredo del Mazo branch) |
| `PlantillaCatalogoDeProductos.xlsx` | Product inventory catalog template |
| `Plantilla Lotes y Caducidades.xlsx` | Batch and expiration date template — displays possible batches/expiry dates per product for selection |
| `PlantillaExistenciasLotes.xlsx` | Batch stock template — compares products by batch with theoretical batch quantities |
| `PlantillaDeExistencias.xlsx` | Stock template — uploads theoretical stock levels |

### Import Workflow (Current)

The client currently performs **separate uploads** for:
1. Products (catalog)
2. Batches and expiration dates
3. Theoretical stock levels (by batch and overall)

This is done per inventory session via Excel files.

---

## Asset Categories and Statuses

| Question | Answer |
|----------|--------|
| Additional statuses needed? | **No**, only the 4 confirmed: Found, Not Found, Added, Transferred |
| Asset categories? | **Loaded from catalog upload**, not predefined |
| Responsible person/department? | **No** — high staff turnover in Mexico, so **branch is responsible** |
| Transfer approval? | Create a new role: **"Guest Supervisor"** (Supervisor Invitado) who performs transfers |

### Updated Role List

| Role | Description |
|------|-------------|
| Super Administrador | System-wide admin |
| Supervisor de inventarios | Manages inventory sessions |
| Capturista de inventario | Data entry / field scanning |
| **Supervisor Invitado** (NEW) | Guest supervisor who can perform asset transfers |

---

## Web Platform Hosting

| Question | Answer |
|----------|--------|
| Where to host? | **Subdomain** on existing CPanel: **app.seretail.com.mx** |
| Server specs? | Client doesn't know — shared CPanel access |
| New server? | Open to recommendations. **Disk is at ~80% (59.8 GB / 75 GB)** |
| Domain ready? | **app.seretail.com.mx** |

### Hosting Concern

CPanel disk usage is at **79.74%** (59.8 GB / 75 GB). With 70K+ assets per company and photos (~48% of scans have images), storage will be a problem. **Cloud hosting or storage upgrade recommended.**

---

## Access Credentials Provided

| System | URL | Username | Password |
|--------|-----|----------|----------|
| Existing Fixed Assets Web App | https://activofijo.seretail.com.mx | Jam | Jam01 |
| HostGator CPanel | https://billing.hostgator.mx | alang_villegas@hotmail.com | *Alasua2134 |
