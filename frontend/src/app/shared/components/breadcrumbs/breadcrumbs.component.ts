import { Component } from '@angular/core';
import { Router, ActivatedRoute, NavigationEnd } from '@angular/router';
import { CommonModule } from '@angular/common';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-breadcrumbs',
  standalone: true,
  imports: [CommonModule],
  template: `
    <nav class="text-sm text-slate-500 mb-4">
      <ol class="flex gap-2">
        <li *ngFor="let bc of breadcrumbs">
          <span>{{ bc }}</span>
          <span *ngIf="bc !== breadcrumbs[breadcrumbs.length - 1]">/</span>
        </li>
      </ol>
    </nav>
  `,
})
export class BreadcrumbsComponent {
  breadcrumbs: string[] = [];

  constructor(private router: Router) {
    this.router.events
      .pipe(filter((e) => e instanceof NavigationEnd))
      .subscribe(() => {
        this.breadcrumbs = this.router.url
          .split('/')
          .filter((p) => p)
          .map((p) => decodeURIComponent(p));
      });
  }
}
