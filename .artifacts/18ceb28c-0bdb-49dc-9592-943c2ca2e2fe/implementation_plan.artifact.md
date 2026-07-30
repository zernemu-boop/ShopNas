# Redesign Intent Screen to Modern UI/UX

Redesign the `IntentScreen.kt` to provide a more modern, professional, and user-friendly interface using Jetpack Compose and Material 3 principles. The functionality will remain the same, but the presentation will be enhanced with cards, icons, and a cleaner layout.

## User Review Required

> [!IMPORTANT]
> The redesign switches from a simple vertical list of buttons to a grid of interactive cards. This significantly changes the visual weight of each action.
>
> [!NOTE]
> I will replace the hardcoded colors (Cyan/Blue) with `MaterialTheme.colorScheme` to ensure consistency with the app's theme and support for dark mode.

## Proposed Changes

### UI Components

#### [MODIFY] [IntentScreen.kt](file:///C:/Users/hp/StudioProjects/ShopNas/app/src/main/java/com/example/shopnas/ui/screens/intent/IntentScreen.kt)

-   Replace the `Column` with a `Scaffold` and `LazyVerticalGrid`.
-   Use `MediumTopAppBar` for a more modern header.
-   Create a reusable `IntentActionCard` component that includes:
    -   An icon representing the action.
    -   A title for the action.
    -   A brief description to guide the user.
-   Group actions logically (e.g., Communication, Payments, Utilities).
-   Use Material 3 `ElevatedCard` for interactive elements.
-   Remove hardcoded colors and use `MaterialTheme.colorScheme`.

## Verification Plan

### Automated Tests
-   I will use `render_compose_preview` to verify the visual changes of `IntentScreenPreview`.

### Manual Verification
-   Verify that clicking each card still triggers the correct Android Intent (M-Pesa, SMS, Call, etc.).
-   Check the layout on different screen sizes (if possible via preview).
