import { Routes } from '@angular/router';

export const routes: Routes = [
  // Redirect raiz → analytics (dashboard)
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'analytics',
  },

  // 1. Auth Flow
  { path: 'auth/login',
    loadComponent: () =>
      import('./features/auth/login-page.component')
        .then(m => m.LoginPageComponent),
  },
  {
    path: 'auth/forgot-password',
    loadComponent: () =>
      import('./features/auth/forgot-password-page.component')
        .then(m => m.ForgotPasswordPageComponent),
  },
  {
    path: 'auth/reset-password/:token',
    loadComponent: () =>
      import('./features/auth/reset-password-page.component')
        .then(m => m.ResetPasswordPageComponent),
  },

  // 2. User Flow
  {
    path: 'users',
    loadComponent: () =>
      import('./features/users/users-page.component')
        .then(m => m.UsersPageComponent),
  },
  {
    path: 'users/:id',
    loadComponent: () =>
      import('./features/users/user-detail-page.component')
        .then(m => m.UserDetailPageComponent),
  },

  // 3. Work Orders Flow
  {
    path: 'work-orders',
    loadComponent: () =>
      import('./features/work-orders/work-orders-page.component')
        .then(m => m.WorkOrdersPageComponent),
  },
  {
    path: 'work-orders/:id',
    loadComponent: () =>
      import('./features/work-orders/work-order-detail-page.component')
        .then(m => m.WorkOrderDetailPageComponent),
  },

  // 4. Analytics Flow
  {
    path: 'analytics',
    loadComponent: () =>
      import('./features/analytics/analytics-dashboard-page.component')
        .then(m => m.AnalyticsDashboardPageComponent),
  },

  // 5. File Storage Flow
  {
    path: 'files',
    loadComponent: () =>
      import('./features/files/files-page.component')
        .then(m => m.FilesPageComponent),
  },

  // 6. Notifications Flow
  {
    path: 'notifications',
    loadComponent: () =>
      import('./features/notifications/notifications-page.component')
        .then(m => m.NotificationsPageComponent),
  },

  // 7. Billing Flow
  {
    path: 'billing',
    loadComponent: () =>
      import('./features/billing/billing-page.component')
        .then(m => m.BillingPageComponent),
  },

  // 8. Integrations Flow
  {
    path: 'integrations',
    loadComponent: () =>
      import('./features/integrations/integrations-page.component')
        .then(m => m.IntegrationsPageComponent),
  },

  // 9. Admin Flow
  {
    path: 'admin',
    loadComponent: () =>
      import('./features/admin/admin-page.component')
        .then(m => m.AdminPageComponent),
  },

  // 10. Reports Flow
  {
    path: 'reports',
    loadComponent: () =>
      import('./features/reports/reports-page.component')
        .then(m => m.ReportsPageComponent),
  },

  // 11. Messaging / Events Flow
  {
    path: 'messages',
    loadComponent: () =>
      import('./features/messages/messages-page.component')
        .then(m => m.MessagesPageComponent),
  },
  {
    path: 'events',
    loadComponent: () =>
      import('./features/events/events-page.component')
        .then(m => m.EventsPageComponent),
  },

  // 12. Config / Settings
  {
    path: 'settings',
    loadComponent: () =>
      import('./features/settings/settings-page.component')
        .then(m => m.SettingsPageComponent),
  },

  // 13. Dev Tools (somente ambiente DEV)
  {
    path: 'dev',
    loadComponent: () =>
      import('./features/dev/dev-tools-page.component')
        .then(m => m.DevToolsPageComponent),
  },

  // Fallback
  { path: '**', redirectTo: 'analytics' },
];
