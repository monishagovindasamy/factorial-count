import { Component } from '@angular/core';
import { ApiService } from '@fc/service/api.service';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss'],
})
export class UploadComponent {
  currentFile?: File;

  message = '';

  fileName = 'Select File';

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {}

  selectFile(event: any): void {
    if (event.target.files && event.target.files[0]) {
      const file: File = event.target.files[0];
      this.currentFile = file;
      this.fileName = this.currentFile.name;
    } else {
      this.fileName = 'Select File';
    }
  }

  upload(): void {
    this.message = '';
    if (this.currentFile) {
      this.apiService.upload(this.currentFile).subscribe({
        next: (response) => {
          this.message = 'Factorial Count ' + response.fc;
        },
        error: (err: any) => {
          if (err.error && err.error.message) {
            this.message = err.error.message;
          } else {
            this.message = 'Could not upload the file!';
          }
          this.currentFile = undefined;
        },
      });
    }
  }
}
