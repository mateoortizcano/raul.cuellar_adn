import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'inicialesPalabras'
})
export class InicialesPalabrasPipe implements PipeTransform {

  transform(value: string): string {
    var matches = value.match(/\b(\w)/g);
    return matches.join('');
  }

}
