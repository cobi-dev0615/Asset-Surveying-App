# Client Requests by Week

This document lists everything you need to ask the client, organized by when you need it. Send each request at the start of the corresponding week so there is time for the client to respond.

---

## Before Project Starts (Send Immediately)

These items are needed before any development can begin.

### 1. CPanel / WordPress Access

> I need access to your current web platform to analyze the existing database structure and plan the data migration.
>
> Please provide:
> - CPanel login URL, username, and password
> - WordPress admin URL, username, and password
> - MySQL database host, name, username, and password (found in CPanel > MySQL Databases)
> - phpMyAdmin access (if available)

### 2. Current APK Files

> Please confirm that the three APK files you shared are the latest versions:
> - SERV122.apk (Inventory, v1.2.2)
> - ActivoFijoV113.apk (Fixed Assets, v1.1.3)
> - ActivoFijoV200RFID.apk (RFID, v2.0.0)
>
> Do you have any newer versions of these apps?

### 3. Business Context

> To design the database and user interface correctly, I need to understand your current operations:
> - How many branches/locations does your company operate?
> - Approximately how many fixed assets do you manage in total?
> - Approximately how many products are in your inventory catalog?
> - How many users will use the Android app simultaneously?
> - How many users will access the web platform?

### 4. Branding

> For the app and web platform design:
> - What should the app be named?
> - Do you have a company logo file (PNG or SVG, high resolution)?
> - Do you have preferred brand colors?
> - Should the app language be Spanish only, or Spanish and English?

---

## Week 1 Requests

Send these at the start of week 1.

### 5. Sample Data Files

> To test the import functionality and validate the database schema, please send me:
> - A sample Excel file of your asset catalog (the format your team currently uses)
> - A sample Excel file of your product inventory catalog
> - A list of all your branches with their names and addresses
> - A list of all user accounts that should be migrated (usernames, roles, branch assignments — no passwords needed)

### 6. Asset Categories and Statuses

> You mentioned four asset statuses: Found, Not Found, Added, and Transferred.
>
> Please confirm:
> - Are there any additional statuses you need? (for example: Disposed, Under Repair, Reserved)
> - What asset categories do you use? (for example: Furniture, Electronics, Vehicles, Machinery)
> - Do assets have a responsible person or department assigned to them?
> - When an asset is transferred between branches, who approves the transfer?

### 7. Web Platform Hosting

> Where would you like the new web platform hosted?
> - On your existing CPanel hosting? (please confirm server specs: PHP version, MySQL version, storage space)
> - On a new server? (I can recommend cloud hosting options)
> - Do you have a domain name ready for the new platform?

---

## Week 2 Requests

Send these at the start of week 2 along with the Week 1 demo.

### 8. UI/UX Feedback

> I am sharing with you:
> - A working web admin panel (login URL and credentials)
> - An Android APK file you can install on any phone
>
> Please review both and answer:
> - Does the navigation flow make sense for your team?
> - Are there any screens or fields missing that your team needs?
> - Is the screen layout comfortable on your devices?
> - Any changes to colors, fonts, or layout?

### 9. User Roles and Permissions

> The current apps have basic admin/user roles. For the unified app, please define what each role can do:
> - **Administrator**: What can they do? (create users, manage branches, view all reports, configure settings?)
> - **Supervisor**: What can they do? (start inventory sessions, assign tasks, approve transfers?)
> - **Field Worker**: What can they do? (scan items, capture photos, view their own reports only?)
> - Are there any other roles needed?

### 10. Report Requirements

> I am implementing reports based on the existing apps. Please confirm which reports you need:
> - Inventory count by product (aggregated totals)
> - Inventory count by product and location
> - Detailed line-by-line report
> - Variance report (theoretical vs actual)
> - Asset status summary (found/not found/added/transferred by branch)
> - Transfer history report
> - Any other reports your team needs?

---

## Week 3 Requests

Send these at the start of week 3 along with the functional APK demo.

### 11. API Structure Approval

> I am sharing the API documentation (Swagger/OpenAPI) for your review.
>
> This defines how the Android app communicates with the web server.
> Please review and confirm:
> - Are all the data fields correct?
> - Are there any missing endpoints you need?
> - Should any third-party systems integrate with this API in the future?

### 12. Sync and Conflict Rules

> When multiple devices capture data offline and then sync to the server, conflicts can occur.
>
> Please confirm how you want conflicts handled:
> - If two users scan the same asset at different locations, which record wins?
> - Should the server always be the source of truth? (recommended)
> - How often should auto-sync run? (every 5 minutes, every 15 minutes, manual only?)
> - Should sync happen only on WiFi, or also on mobile data?

### 13. WordPress Database Export

> I need a fresh export of your current database to begin migration work next week.
>
> Please provide:
> - A MySQL dump file exported from phpMyAdmin (or I can export it myself if you gave CPanel access)
> - Identify which tables contain: users, branches, assets, inventory records
> - Are there any records that should NOT be migrated? (test data, old records)

---

## Week 4 Requests (Critical)

Send these at the start of week 4. The Rugline device request is time-sensitive.

### 14. Rugline RT501 Device

> **This is the most critical request.** I need the physical Rugline RFID device to complete RFID integration in week 5.
>
> Options:
> - **Ship the device to me** (preferred — I need it for at least 7 days)
> - **Provide remote access** to a device connected to your network (less ideal but workable)
> - **Schedule an on-site session** where I can test with the device in person
>
> Please also confirm:
> - What Android version is running on the device?
> - Is the Rugline SDK installed or do I need to install it?
> - Do you have the Rugline SDK documentation or download link?

### 15. Doying Handheld POS Device

> I also need to test on the Doying barcode scanner device.
>
> - Can you ship this device along with the Rugline?
> - If not, does the Doying device use the standard Android camera for scanning, or does it have a dedicated hardware scanner with its own SDK?
> - What Android version is running on the device?

### 16. Bluetooth Printer Details

> To implement printing, I need:
> - The exact model of your Bluetooth printer(s)
> - Is it ESC/POS (receipt printer) or Zebra (label printer) or both?
> - Can you ship a printer for testing, or should I use a common model?
> - What information should be printed on:
>   - Asset labels (barcode + what text?)
>   - Inventory count receipts (what fields?)
>   - Location summary reports (what data?)

### 17. Production Server Details

> For deploying the web platform to production:
> - Will you use your existing CPanel hosting or a new server?
> - What is the domain name for the new platform?
> - Do you need SSL/HTTPS? (recommended)
> - Do you have email SMTP settings for sending notifications? (password reset, transfer alerts)

### 18. Data Migration Validation

> I have completed the data migration from your WordPress database.
>
> Please review:
> - Log in to the new web platform and verify your data is correct
> - Check user accounts, branches, and asset records
> - Identify any missing or incorrect data
> - Confirm we are ready to proceed with the new system

---

## Week 5 Requests

Send these at the start of week 5.

### 19. RFID Configuration

> Now that I have the Rugline device, I need to confirm:
> - What RF power level do you normally use? (low, medium, high)
> - Do you use single antenna or multiple antennas?
> - What is the typical scanning distance you need? (1 meter, 3 meters, 5 meters?)
> - Are your existing RFID tags already encoded with EPC data, or do we need to write new tags?
> - What tag type/brand do you use? (Impinj Monza, Alien Higgs, etc.)

### 20. Final Acceptance Testing

> I am sharing the final build for your testing.
>
> Please test the following scenarios and report any issues:
> - [ ] Log in to the web platform with your account
> - [ ] Log in to the Android app with the same account
> - [ ] Create an inventory session on the web platform
> - [ ] On the Android app, scan items using barcode (Doying or phone camera)
> - [ ] On the Android app, scan items using RFID (Rugline device)
> - [ ] Take photos of assets
> - [ ] Switch to airplane mode and continue scanning (offline test)
> - [ ] Turn WiFi back on and trigger sync
> - [ ] Verify synced data appears on the web platform
> - [ ] View reports on web platform
> - [ ] Export a report to Excel
> - [ ] Print an asset label via Bluetooth printer
> - [ ] Scan an asset from another branch (transfer test)
>
> Please provide feedback within 2 days so I can fix any issues before final delivery.

---

## Summary: Request Timeline

| When | What to Request | Priority |
|------|-----------------|----------|
| **Before start** | CPanel access, APK confirmation, business context, branding | Critical |
| **Week 1** | Sample data files, asset categories/statuses, hosting preferences | High |
| **Week 2** | UI/UX feedback, user roles, report requirements | High |
| **Week 3** | API approval, sync rules, WordPress DB export | High |
| **Week 4** | Rugline device, Doying device, printer details, server details, migration validation | Critical |
| **Week 5** | RFID configuration, final acceptance testing | Critical |

---

## Communication Template

Use this template when sending weekly requests to the client:

> **Subject: [Project Name] — Week X Update & Requests**
>
> Hi [Client Name],
>
> Here is what I completed this week:
> - [Deliverable 1]
> - [Deliverable 2]
> - [Demo link or APK file]
>
> To continue on schedule, I need the following from you by [date]:
> 1. [Request 1]
> 2. [Request 2]
> 3. [Request 3]
>
> Please let me know if you have any questions about what was delivered or what I am requesting.
>
> Best regards,
> [Your Name]
