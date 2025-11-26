import { Component } from '@angular/core';

@Component({
  selector: 'app-toolbar',
  standalone: true,
  template: `
    <div class="flex items-center justify-between mb-4">
      <ng-content></ng-content>
    </div>
  `,
})
export class ToolbarComponent {}
