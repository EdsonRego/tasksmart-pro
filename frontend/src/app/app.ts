import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NgClass, CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NgClass, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class AppComponent {
  sidebarCollapsed = false;

  toggleSidebar() {
    this.sidebarCollapsed = !this.sidebarCollapsed;
  }

  appName = 'TaskSmart Pro';
}
