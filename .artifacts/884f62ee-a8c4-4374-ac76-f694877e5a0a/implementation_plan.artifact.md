# Implementation Plan - Fully Functional ShopNas App

This plan outlines the steps to make all buttons, icons, and navigation functional throughout the ShopNas app, ensuring a proper user flow while maintaining existing code structure.

## User Review Required

> [!IMPORTANT]
> I will be introducing a shared `BottomNavigationBar` component to maintain consistency across the app. This will be added to `HomeScreen`, `DashboardScreen`, `ViewOrdersScreen`, and `OrderUploadScreen`.

## Proposed Changes

### Navigation & Core Flow

#### [MODIFY] [AppNavHost.kt](file:///C:/Users/hp/StudioProjects/ShopNas/app/src/main/java/com/example/shopnas/navigation/AppNavHost.kt)
- Fix the destination for `ROUT_VIEW_ORDER` to point to `ViewOrdersScreen`.
- Import necessary screen components.

#### [NEW] [BottomNavBar.kt](file:///C:/Users/hp/StudioProjects/ShopNas/app/src/main/java/com/example/shopnas/ui/components/BottomNavBar.kt)
- Create a reusable `BottomNavigationBar` with tabs for Home, Shop (Order Upload), Orders (View Orders), and Profile (Dashboard).

### Authentication

#### [MODIFY] [AuthViewModel.kt](file:///C:/Users/hp/StudioProjects/ShopNas/app/src/main/java/com/example/shopnas/data/AuthViewModel.kt)
- Navigate to `ROUT_LOGIN` after a successful signup to allow users to sign in.

### Screen Functionality

#### [MODIFY] [HomeScreen.kt](file:///C:/Users/hp/StudioProjects/ShopNas/app/src/main/java/com/example/shopnas/ui/screens/home/HomeScreen.kt)
- Add `BottomNavigationBar` to the `Scaffold`.
- Connect TopAppBar icons: Menu -> Dashboard, ShoppingCart -> View Orders.
- Make `ProductCard` clickable, navigating to `ROUT_UPLOAD_ORDER`.
- Connect "See All" to `ROUT_UPLOAD_ORDER` (or a relevant shop page).

#### [MODIFY] [DashboardScreen.kt](file:///C:/Users/hp/StudioProjects/ShopNas/app/src/main/java/com/example/shopnas/ui/screens/dashboard/DashboardScreen.kt)
- Add `BottomNavigationBar`.
- Connect TopAppBar Settings -> `IntentScreen`.
- Connect Stats cards to `ViewOrdersScreen`.
- Connect "Customer Actions" button (already connected to `IntentScreen`).

#### [MODIFY] [OrderUploadScreen.kt](file:///C:/Users/hp/StudioProjects/ShopNas/app/src/main/java/com/example/shopnas/ui/screens/orders/OrderUploadScreen.kt)
- Replace existing `NavigationBar` with the new shared `BottomNavigationBar`.
- Connect TopAppBar back button.

#### [MODIFY] [ViewOrdersScreen.kt](file:///C:/Users/hp/StudioProjects/ShopNas/app/src/main/java/com/example/shopnas/ui/screens/orders/ViewOrdersScreen.kt)
- Replace existing `NavigationBar` with the new shared `BottomNavigationBar`.
- Connect FloatingActionButton to `ROUT_UPLOAD_ORDER`.
- Connect TopAppBar icons.

## Verification Plan

### Automated Tests
- Build the project to ensure no compilation errors.
- Run Compose Previews for all modified screens to verify UI consistency.

### Manual Verification
- Deploy to a device/emulator.
- Walk through the entire flow: Splash -> Onboarding -> Register -> Login -> Home -> Shop -> View Orders -> Dashboard -> Intent.
- Verify that every button and icon performs the expected navigation or action.
