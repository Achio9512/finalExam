import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CrudsExamenSharedModule } from 'app/shared/shared.module';
import { DeparmentComponent } from './deparment.component';
import { DeparmentDetailComponent } from './deparment-detail.component';
import { DeparmentUpdateComponent } from './deparment-update.component';
import { DeparmentDeleteDialogComponent } from './deparment-delete-dialog.component';
import { deparmentRoute } from './deparment.route';

@NgModule({
  imports: [CrudsExamenSharedModule, RouterModule.forChild(deparmentRoute)],
  declarations: [DeparmentComponent, DeparmentDetailComponent, DeparmentUpdateComponent, DeparmentDeleteDialogComponent],
  entryComponents: [DeparmentDeleteDialogComponent],
})
export class CrudsExamenDeparmentModule {}
